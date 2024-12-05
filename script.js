document.getElementById('playButton').addEventListener('click', () => {
    const gameSelect = document.getElementById('gameSelect');
    const selectedGame = gameSelect.value;
    window.location.href = selectedGame;
});

