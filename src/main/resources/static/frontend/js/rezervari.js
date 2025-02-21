document.getElementById('bookingForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const checkIn = document.getElementById('checkIn').value;
    const checkOut = document.getElementById('checkOut').value;
    const cameraId = localStorage.getItem('cameraSelectata');

    fetch('/api/rezervari', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ checkIn, checkOut, cameraId })
    }).then(response => response.json())
        .then(data => {
            document.getElementById('bookingResult').textContent =
                'Rezervare creată cu succes!';
        });
});

