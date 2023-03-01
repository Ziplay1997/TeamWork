package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() { //1

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldGetMostPlayerEquallyOne() {//8

        GameStore store = new GameStore();

        store.addPlayTime("Виктор", 1);
        store.addPlayTime("Влад", 5);

        String actual = store.getMostPlayer();
        String expected = "Влад";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnFalseAddGames() {// 2

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Counter-Strike", "Shooter", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldReturnFalseContainsGame() {// 3

        GameStore store = new GameStore();

        Game game2 = new Game("Counter-Strike", "Shooter", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldGetMostPlayer() {//4

        GameStore store = new GameStore();

        store.addPlayTime("Витя", 2);
        store.addPlayTime("Влад", 4);
        store.addPlayTime("Костя", 3);


        String actual = store.getMostPlayer();
        String expected = "Влад";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerReturnNull() {//5

        GameStore store = new GameStore();

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(null, actual);
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegativeValue() {//6

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("Витя", -1);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(null, actual);
    }

    @Test
    public void shouldRegisteredAddPlayTime() {//7

        GameStore store = new GameStore();

        store.addPlayTime("Виктор", 0);
        store.addPlayTime("Влад", 2);


        String actual = store.getMostPlayer();
        String expected = "Влад";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerEqualsZero() {// 9

        GameStore store = new GameStore();
        Game game = store.publishGame("Counter-Strike", "Shooter");

        store.addPlayTime("Витя", 0);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }


    @Test
    public void shouldGetSumPlayedTime() {//10

        GameStore store = new GameStore();

        store.addPlayTime("Александр", 1);
        store.addPlayTime("Евгений", 4);
        store.addPlayTime("Михаил", 2);

        int actual = store.getSumPlayedTime();
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumOnePlayedTime() {// 13

        GameStore store = new GameStore();

        store.addPlayTime("Витя", 0);
        store.addPlayTime("Влад", 1);
        store.addPlayTime("Костя", 0);

        int actual = store.getSumPlayedTime();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumZeroPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Витя", 0);
        store.addPlayTime("Влад", 0);
        store.addPlayTime("Костя", 0);

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnZeroGetSumPlayedTime() {//11

        GameStore store = new GameStore();

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }

}
