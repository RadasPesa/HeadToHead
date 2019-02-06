package h2h;

class Loading {

    void tick() {
        if(DisplayTimer.loadingSecondsRemaining <= 0) {
            // LOADING FINISHED
            Game.getRandomQuestions(HeadToHead.difficulty);
            Game.scoreOfFirstPlayer = 0;
            Game.scoreOfSecondPlayer = 0;
            DisplayTimer.loadingSecondsRemaining = 3;
            HeadToHead.state = HeadToHead.STATE.GAME;
        }
    }
}
