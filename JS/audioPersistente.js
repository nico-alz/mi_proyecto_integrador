window.addEventListener('DOMContentLoaded', () => {
  const audio = document.getElementById('musicaFondo');
  if (audio) {
    audio.volume = 0.3;
    audio.play().catch(() => {
      document.body.addEventListener('click', () => {
        audio.play();
      }, { once: true });
    });
  }
});