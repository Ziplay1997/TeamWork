package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldGetMostPlayerEquallyOne() {

        GameStore store = new GameStore();

        store.addPlayTime("Виктор", 1);

        String actual = store.getMostPlayer();
        String expected = "Виктор";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseAddGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Counter-Strike", "Shooter", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldReturnFalseContainsGame() {

        GameStore store = new GameStore();

        Game game2 = new Game("Counter-Strike", "Shooter", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Витя", 2);
        store.addPlayTime("Влад", 4);
        store.addPlayTime("Костя", 3);


        String actual = store.getMostPlayer();
        String expected = "Влад";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerReturnNull() {

        GameStore store = new GameStore();

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(null, actual);
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegativeValue() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Витя", -1);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(null, actual);
    }

    @Test
    public void shouldRegisteredAddPlayTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Виктор", 0);
        store.addPlayTime("Влад", 2);


        String actual = store.getMostPlayer();
        String expected = "Влад";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerEqualsZero() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Counter-Strike", "Shooter");

        store.addPlayTime("Витя", 0);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void TestSumGenreTwoGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Diablo", "RPG");
        Game game1 = store.publishGame("Wow", "RPG");
        Game game3 = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Виктор");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 3);
        player.play(game1, 2);
        player.play(game3, 1);
        player.play(game1, 1);

        int expected = 3;
        int actual = player.sumGenre("RPG");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Александр", 1);
        store.addPlayTime("Евгений", 4);
        store.addPlayTime("Михаил", 2);

        int actual = store.getSumPlayedTime();
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumOnePlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Витя", 0);
        store.addPlayTime("Влад", 1);
        store.addPlayTime("Костя", 0);

        int actual = store.getSumPlayedTime();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroGetSumPlayedTime() {

        GameStore store = new GameStore();

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }

}
