package com.jean.naturaeco.entity;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "tbl_Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id;
    @Column(name = "nome_produto", nullable = false, length = 50)
    private String nome;
    @Column(name = "detalhe_produto", columnDefinition = "TEXT")
    private String detalhe;
    @Column(name = "link_foto", length = 255)
    private String linkFoto;
    @Column(name = "disponivel")
    private Integer disponivel;
    @Column(name = "preco_produto", nullable = false)
    private Double preco;

    @ManyToOne()
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        this.disponivel = disponivel;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", detalhe='" + detalhe + '\'' +
                ", linkFoto='" + linkFoto + '\'' +
                ", preco=" + preco +
                ", categoria=" + categoria +
                '}';
    }
}
