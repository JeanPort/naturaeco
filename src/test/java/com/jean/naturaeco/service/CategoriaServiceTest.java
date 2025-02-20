package com.jean.naturaeco.service;

import com.jean.naturaeco.dto.request.CategoriaPostRequest;
import com.jean.naturaeco.dto.request.CategoriaPutRequest;
import com.jean.naturaeco.dto.response.CategoriaResponse;
import com.jean.naturaeco.entity.Categoria;
import com.jean.naturaeco.exception.NotFoundException;
import com.jean.naturaeco.exception.ValidationErrorException;
import com.jean.naturaeco.mapper.CategoriaMapper;
import com.jean.naturaeco.repo.CategoriaRepo;
import com.jean.naturaeco.service.categoria.CategoriaServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @InjectMocks
    private CategoriaServiceImpl service;

    @Mock
    private CategoriaRepo repo;

    private List<Categoria> categorias;
    private CategoriaPostRequest postRequest;
    private CategoriaPostRequest postRequestInvalida;
    private CategoriaResponse postResponse;
    private CategoriaPutRequest putRequest;
    private List<CategoriaResponse> listResponse;

    @BeforeEach
    void init() {
        this.categorias = List.of(new Categoria(1, "Cosmetico"), new Categoria(2, "Cabelo"), new Categoria(3, "Pele"));
        this.postRequest = new CategoriaPostRequest("Novo");
        this.postRequestInvalida = new CategoriaPostRequest("Cosmetico");
        this.postResponse = new CategoriaResponse(4, this.postRequest.nome());
        this.putRequest = new CategoriaPutRequest(1, "atualizado");
        this.listResponse = CategoriaMapper.toListCategoriaResponse(this.categorias);
    }

    @Test
    void createCategoria_ComDadosValidos_DeveRetornarCategoriaResponse(){
        var categoria = CategoriaMapper.toCategoria(this.postRequest);
        categoria.setId(4);
        Mockito.when(repo.save(CategoriaMapper.toCategoria(this.postRequest))).thenReturn(categoria);
        var response = service.create(this.postRequest);

        Assertions.assertThat(response).isEqualTo(this.postResponse);
    }
    @Test
    void createCategoria_ComDadosInvalidos_DeveRetornarException(){
        var res = this.categorias.get(0);
        Mockito.when(repo.findByNome(this.postRequestInvalida.nome())).thenReturn(Optional.of(res));

        Assertions.assertThatException().isThrownBy(() -> service.create(this.postRequestInvalida)).isInstanceOf(ValidationErrorException.class);
    }


    @Test
    void updateCategoria_ComDadosValidos_DeveRetornarCategoriaResponse(){
        var categoria = CategoriaMapper.toCategoria(this.putRequest);
        Mockito.when(repo.findById(categoria.getId())).thenReturn(Optional.of(categoria));
        Mockito.when(repo.findByNome(categoria.getNome())).thenReturn(Optional.empty());
        Mockito.when(repo.save(categoria)).thenReturn(categoria);

        var response = service.update(this.putRequest);
        Assertions.assertThat(response.nome()).isEqualTo(this.putRequest.nome());
        Assertions.assertThat(response.id()).isEqualTo(this.putRequest.id());
    }

    @Test
    void updateCategoria_ComIdInvalidos_DeveRetornarException(){

        var updataInvalid = new CategoriaPutRequest(19, "Cabelo");
        Mockito.when(repo.findById(updataInvalid.id())).thenReturn(Optional.empty());

        Assertions.assertThatException().isThrownBy(() -> service.update(updataInvalid)).isInstanceOf(NotFoundException.class);
    }

    @Test
    void updateCategoria_ComNomeInvalidos_DeveRetornarException(){

        var updataInvalid = new CategoriaPutRequest(1, "Cabelo");
        Mockito.when(repo.findById(updataInvalid.id())).thenReturn(Optional.of(CategoriaMapper.toCategoria(updataInvalid)));
        Mockito.when(repo.findByNome(updataInvalid.nome())).thenReturn(Optional.of(this.categorias.get(1)));

        Assertions.assertThatException().isThrownBy(() -> service.update(updataInvalid)).isInstanceOf(ValidationErrorException.class);
    }
    @Test
    void deleteCategoria_ComIdExistente_DeveRemoverCategoria(){
        var categoria = this.categorias.get(0);
        Mockito.when(repo.findById(categoria.getId())).thenReturn(Optional.of(categoria));
        Assertions.assertThatNoException().isThrownBy(() -> service.delete(categoria.getId()));
    }
    @Test
    void deleteCategoria_ComIdInexistente_DeveLancarExcecaoNotFound(){
        var id = 19;
        Mockito.when(repo.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThatException().isThrownBy(() -> service.delete(id)).isInstanceOf(NotFoundException.class);
    }
    @Test
    void findAllCategorias_DeveRetornarListaDeCategoriaResponse(){
        Mockito.when(repo.findAll()).thenReturn(this.categorias);
        var responses = service.findAll();
        Assertions.assertThat(responses).isNotNull().hasSameElementsAs(this.listResponse);
    }
    @Test
    void findByIdCategoria_ComIdExistente_DeveRetornarCategoriaResponse(){

        var categoriaResponse = this.listResponse.get(0);
        Mockito.when(repo.findById(categoriaResponse.id())).thenReturn(Optional.of(this.categorias.get(0)));

        var response = service.findById(categoriaResponse.id());
        Assertions.assertThat(response).isEqualTo(categoriaResponse);
    }
    @Test
    void findByIdCategoria_ComIdInexistente_DeveLancarExcecaoNotFound(){
        var id = 10;
        Mockito.when(repo.findById(id)).thenReturn(Optional.empty());

        Assertions.assertThatException().isThrownBy(() -> service.findById(id)).isInstanceOf(NotFoundException.class);
    }
}
