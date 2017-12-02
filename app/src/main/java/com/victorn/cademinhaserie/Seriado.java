package com.victorn.cademinhaserie;

public class Seriado {

    private int id;
    private String nome;
    private String ano;
    private String criador;
    private String elencoPrincipal;
    private String temporadas;
    private String atividade;
    private String trama;
    private String generos;
    private String paisOrigem;
    private String tempoEpisodio;

    public Seriado(int id, String nome, String ano, String criador, String elencoPrincipal, String temporadas, String atividade, String trama, String generos, String paisOrigem, String tempoEpisodio) {
        this.id = id;
        this.nome = nome;
        this.ano = ano;
        this.criador = criador;
        this.elencoPrincipal = elencoPrincipal;
        this.temporadas = temporadas;
        this.atividade = atividade;
        this.trama = trama;
        this.generos = generos;
        this.paisOrigem = paisOrigem;
        this.tempoEpisodio = tempoEpisodio;
    }

    public Seriado(String nome, String ano, String criador, String elencoPrincipal, String temporadas, String atividade, String trama, String generos, String paisOrigem, String tempoEpisodio) {
        this.nome = nome;
        this.ano = ano;
        this.criador = criador;
        this.elencoPrincipal = elencoPrincipal;
        this.temporadas = temporadas;
        this.atividade = atividade;
        this.trama = trama;
        this.generos = generos;
        this.paisOrigem = paisOrigem;
        this.tempoEpisodio = tempoEpisodio;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getAno() {
        return ano;
    }

    public String getCriador() {
        return criador;
    }

    public String getElencoPrincipal() {
        return elencoPrincipal;
    }

    public String getTemporadas() {
        return temporadas;
    }

    public String getAtividade() {
        return atividade;
    }

    public String getTrama() {
        return trama;
    }

    public String getGeneros() {
        return generos;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public String getTempoEpisodio() {
        return tempoEpisodio;
    }
}
