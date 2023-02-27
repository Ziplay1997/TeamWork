package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // новые тесты

    @Test
    public void TestSumGenreTwoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Call of Duty", "Battle Royale");
        Game game1 = store.publishGame("Uncharted", "Battle Royale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game1, 2);
        player.play(game3, 1);
        player.play(game1, 1);

        int expected = 3;
        int actual = player.sumGenre("Battle Royale");
        assertEquals(expected, actual);
    }

    @Test
    public void addDoubleGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Call of Duty", "Battle Royale");
        Game game2 = store.publishGame("Uncharted", "Battle Royale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 1);
        player.installGame(game);
        player.installGame(game3);
        player.installGame(game3);

        int expected = 0;
        int actual = player.sumGenre(game3.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowRunTimeException() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Call of Duty", "Battle Royale");
        Game game1 = store.publishGame("Uncharted", "Battle Royale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);


        assertThrows(RuntimeException.class, () -> {
            player.play(game3, 1);

        });
    }

    @Test
    public void shouldMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Call of Duty", "Battle Royale");
        Game game1 = store.publishGame("Uncharted", "Battle Royale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game1, 2);
        player.play(game3, 1);

        String expected = "Call of Duty";
        String actual = String.valueOf(player.mostPlayerByGenre("Battle Royale"));
        assertEquals(expected, actual);
    }
    @Test
    public void addPlayGameNegativeValue() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Uncharted", "Battle Royale");

        Player player = new Player("Petya");



        assertThrows(Exception.class, () -> {
            player.play(game1, -1);

        });
    }

    @Test
    public void shouldMostPlayerByGenreNoInstallGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Call of Duty", "Battle Royale");
        Game game1 = store.publishGame("Uncharted", "Battle Royale");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.play(game, 3);
        player.play(game1, 2);


        String expected = null;
        String actual = String.valueOf(player.mostPlayerByGenre("Аркады"));
        assertEquals(expected, actual);
    }
    @Test
    public void shouldInstallNewGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Call of Duty", "Battle Royale");

        Player player = new Player("Petya");
        player.installGame(game);

        boolean expected = true;
        boolean actual = player.playedTime.containsKey(game);

        assertEquals(expected, actual);
    }
}