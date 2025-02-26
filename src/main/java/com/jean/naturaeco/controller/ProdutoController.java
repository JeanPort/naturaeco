package com.jean.naturaeco.controller;

import com.jean.naturaeco.dto.request.ProdutoPostRequest;
import com.jean.naturaeco.dto.request.ProdutoPutRequest;
import com.jean.naturaeco.dto.response.ProdutoResponse;
import com.jean.naturaeco.service.produto.IProdutoService;
import com.jean.naturaeco.service.upload.IUploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final IUploadService uploadService;
    private final IProdutoService service;

    public ProdutoController(IUploadService uploadService, IProdutoService service) {
        this.uploadService = uploadService;
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam(name = "arquivo")MultipartFile arquivo){
        String res = uploadService.upload(arquivo);
        return ResponseEntity.ok(res);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        var res = service.findAll();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Integer id) {
        var res = service.findById(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<ProdutoResponse>> findByCategoria(@PathVariable Integer id) {
        var res = service.findByCategoria(id);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/disponivel")
    public ResponseEntity<List<ProdutoResponse>> findByDisponivel() {
        var res = service.findByDisponiveis();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/busca")
    public ResponseEntity<List<ProdutoResponse>> findByName(@RequestParam(name = "nome") String nome) {
        var res = service.findByNome(nome);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<ProdutoResponse> update(@RequestBody ProdutoPutRequest request) {
        var res = service.update(request);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoPostRequest request) {
        var res = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

}
