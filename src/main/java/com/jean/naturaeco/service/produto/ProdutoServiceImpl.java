package com.jean.naturaeco.service.produto;

import com.jean.naturaeco.dto.request.ProdutoPostRequest;
import com.jean.naturaeco.dto.request.ProdutoPutRequest;
import com.jean.naturaeco.dto.response.ProdutoResponse;
import com.jean.naturaeco.repo.ProdutoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements IProdutoService{

    private final ProdutoRepo repo;

    public ProdutoServiceImpl(ProdutoRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<ProdutoResponse> findAll() {
        return List.of();
    }

    @Override
    public List<ProdutoResponse> findByNome(String nome) {
        return List.of();
    }

    @Override
    public ProdutoResponse findById(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public ProdutoResponse create(ProdutoPostRequest request) {
        return null;
    }

    @Override
    public ProdutoResponse update(ProdutoPutRequest request) {
        return null;
    }
}
