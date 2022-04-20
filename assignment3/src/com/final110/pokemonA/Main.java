package com.final110.pokemonA;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(new Mail("1@mail.sustech.edu.cn"), new
                PhoneNumber("1"), "1");
        Player player2 = new Player(new Mail("2@mail.sustech.edu.cn"),new PhoneNumber("2"),
                "2");
        Skill skill1 = new Skill("skill1", 2, 3);
        Skill skill2 = new Skill("skill2", 3, 2);
        Pokemon pokemon1 = new Pokemon("pokemon1", 10, 1, skill1, 1, 1, 3, 3);
        Pokemon pokemon2 = new Pokemon("pokemon2", 10, 1, skill2, 1, 2, 3, 3);
        player1.addPokemon(pokemon1);
        player2.addPokemon(pokemon2);
        Player winner = Battle.tatakai(player1, player2);

        System.out.println(winner);
    }
}
