document.addEventListener('DOMContentLoaded', function () {
    fetch('/api/camere')
        .then(response => response.json())
        .then(camere => {
            const container = document.getElementById('camereContainer');
            camere.forEach(camera => {
                const div = document.createElement('div');
                div.classList.add('camera');
                div.innerHTML = `
                    <h3>Camera ${camera.numarCamera} - ${camera.tipCamera}</h3>
                    <p>Pret pe noapte: ${camera.pretPeNoapte} RON</p>
                    <button onclick="rezerva(${camera.id})">Rezervă</button>
                `;
                container.appendChild(div);
            });
        });
});

function rezerva(cameraId) {
    localStorage.setItem('cameraSelectata', cameraId);
    window.location.href = 'rezervare.html';
}

