package com.jean.naturaeco.service.produto;

import com.jean.naturaeco.dto.request.ProdutoPostRequest;
import com.jean.naturaeco.dto.request.ProdutoPutRequest;
import com.jean.naturaeco.dto.response.ProdutoResponse;
import com.jean.naturaeco.exception.NotFoundException;
import com.jean.naturaeco.mapper.ProdutoMapper;
import com.jean.naturaeco.repo.CategoriaRepo;
import com.jean.naturaeco.repo.ProdutoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements IProdutoService{

    private final ProdutoRepo repo;
    private final CategoriaRepo categoriaRepo;

    public ProdutoServiceImpl(ProdutoRepo repo, CategoriaRepo categoriaRepo) {
        this.repo = repo;
        this.categoriaRepo = categoriaRepo;
    }

    @Override
    public List<ProdutoResponse> findAll() {
        var list = repo.findAll();
        return ProdutoMapper.toListProdutoResponse(list);
    }

    @Override
    public List<ProdutoResponse> findByNome(String nome) {
        var list = repo.findAllByNomeContaining(nome);
        return ProdutoMapper.toListProdutoResponse(list);
    }

    @Override
    public ProdutoResponse findById(Integer id) {
        var produto = repo.findById(id).orElseThrow(() -> new NotFoundException("Não encontrado"));
        return ProdutoMapper.toProdutoResponse(produto);
    }

    @Override
    public void delete(Integer id) {
        var produto = repo.findById(id).orElseThrow(() -> new NotFoundException("Não encontrado"));
        repo.delete(produto);
    }

    @Override
    public ProdutoResponse create(ProdutoPostRequest request) {
        var categoria = categoriaRepo.findById(request.idCategoria()).orElseThrow(() -> new NotFoundException("Não encotrada"));
        var produto = ProdutoMapper.toProduto(request, categoria);
        produto = repo.save(produto);
        return ProdutoMapper.toProdutoResponse(produto);
    }

    @Override
    public ProdutoResponse update(ProdutoPutRequest request) {
        var categoria = categoriaRepo.findById(request.idCategoria()).orElseThrow(() -> new NotFoundException("Não encotrada"));
        var prod = repo.findById(request.id()).orElseThrow(() -> new NotFoundException("Não encotrada"));
        var produto = ProdutoMapper.toProduto(request, categoria);
        produto = repo.save(produto);
        return ProdutoMapper.toProdutoResponse(produto);
    }

    @Override
    public List<ProdutoResponse> findByCategoria(Integer idCategoria) {
        var categoria = categoriaRepo.findById(idCategoria).orElseThrow(() -> new NotFoundException("Não encontrada"));
        var produtos = repo.findAllByCategoria(categoria);
        return ProdutoMapper.toListProdutoResponse(produtos);
    }

    @Override
    public List<ProdutoResponse> findByDisponiveis() {
        var produtos = repo.findAllByDisponivel(1);
        return ProdutoMapper.toListProdutoResponse(produtos);
    }
}
