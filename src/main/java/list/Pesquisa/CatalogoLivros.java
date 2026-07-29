package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
  // atributo
  private List<Livro> livroList;

  public CatalogoLivros() {
    this.livroList = new ArrayList<>();
  }

  public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
    livroList.add(new Livro(titulo, autor, anoPublicacao));
  }

  public List<Livro> pesquisarPorAutor(String autor) {
    List<Livro> livrosPorAutor = new ArrayList<>();
    if (!livroList.isEmpty()) {
      for (Livro l : livroList) {
        if (l.getAutor().equalsIgnoreCase(autor)) {
          livrosPorAutor.add(l);
        }
      }
      return livrosPorAutor;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }

  public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
    List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
    if (!livroList.isEmpty()) {
      for (Livro l : livroList) {
        if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
          livrosPorIntervaloAnos.add(l);
        }
      }
      return livrosPorIntervaloAnos;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }

  public Livro pesquisarPorTitulo(String titulo) {
    Livro livroPorTitulo = null;
    if (!livroList.isEmpty()) {
      for (Livro l : livroList) {
        if (l.getTitulo().equalsIgnoreCase(titulo)) {
          livroPorTitulo = l;
          break;
        }
      }
      return livroPorTitulo;
    } else {
      throw new RuntimeException("A lista está vazia!");
    }
  }

  public static void main(String[] args) {

    // Criando uma instância do catálogo de livros
    CatalogoLivros catalogoLivros = new CatalogoLivros();

    // Adicionando livros ao catálogo
    catalogoLivros.adicionarLivro("Effective Java", "Joshua Bloch", 2018);
    catalogoLivros.adicionarLivro("Head First Java", "Kathy Sierra", 2022);
    catalogoLivros.adicionarLivro("Refatoração", "Martin Fowler", 2019);
    catalogoLivros.adicionarLivro("Domain-Driven Design", "Eric Evans", 2003);

    // Exibindo livros do mesmo autor
    System.out.println(catalogoLivros.pesquisarPorAutor("Joshua Bloch"));

    // Caso em que o autor não existe no catálogo
    System.out.println(catalogoLivros.pesquisarPorAutor("Autor Inexistente"));

    // Exibindo livros publicados dentro de um intervalo de anos
    System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2015, 2023));

    // Caso em que não há livros no intervalo informado
    System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(1990, 1995));

    // Exibindo livro pelo título
    System.out.println(catalogoLivros.pesquisarPorTitulo("Effective Java"));

    // Caso em que o título não existe
    System.out.println(catalogoLivros.pesquisarPorTitulo("Título Inexistente"));
  }
}
