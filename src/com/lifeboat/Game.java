package com.lifeboat;

import com.lifeboat.gwt.client.model.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Twin
 * @version 1.0
 * @since 28.08.11
 */
public final class Game {
    private static final int GAME_FINISH_BIRDS_COUNT = 4;
    private static final int MIN_PLAYERS_COUNT = 4;

    private final List<Provision> provisions = new ArrayList<Provision>();
    private final List<Navigation> navigations = new ArrayList<Navigation>();
    private final List<Player> players = new ArrayList<Player>();
    private int birdsSeen;

    public void startNewGame(int playersCount) {
        final List<Character> allCharactersList = Arrays.asList(Character.values());
        if (playersCount < MIN_PLAYERS_COUNT || playersCount > allCharactersList.size()) {
            throw new RuntimeException("playersCount < MIN_PLAYERS_COUNT || playersCount > allCharactersList.size()");
        }
        final List<Character> gameCharacters = allCharactersList.subList(0, playersCount);
        final List<Character> loveCharacters = new ArrayList<Character>(gameCharacters);
        final List<Character> hateCharacters = new ArrayList<Character>(gameCharacters);
        final Random random = new Random();
        for (Character gameCharacter : gameCharacters) {
            final Character love = pollRandomly(loveCharacters, random);
            final Character hate = pollRandomly(hateCharacters, random);
            players.add(new Player(gameCharacter, love, hate));
        }
        makeTurn();
    }

    public void makeTurn() {
        //provision phase
        final List<Provision> turnProvisions = provisions.subList(0, Math.min(provisions.size(), players.size()));
        throw new UnsupportedOperationException();
    }

    private <T> T pollRandomly(List<T> list, Random random) {
        return list.remove(random.nextInt(list.size()));
    }

    private boolean isGameFinished() {
        return birdsSeen >= GAME_FINISH_BIRDS_COUNT;
    }

    private Player getNosePlayer() {
        return players.get(0);
    }

    private Player getNavigationPlayer() {
        return players.get(players.size() - 1);
    }
}
