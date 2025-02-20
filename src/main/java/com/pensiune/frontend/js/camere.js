document.addEventListener("DOMContentLoaded", async function() {
    const response = await fetch("http://localhost:8080/api/camere");
    const camere = await response.json();

    const camereContainer = document.getElementById("lista-camere");
    camere.forEach((camera) => {
        const div = document.createElement("div");
        div.innerHTML = `
            <h3>Camera ${camera.numarCamera}</h3>
            <p>Tip: ${camera.tipCamera}</p>
            <p>Preț pe noapte: ${camera.pretPeNoapte} RON</p>
            <p>${camera.disponibila ? "Disponibilă" : "Ocupată"}</p>
        `;
        camereContainer.appendChild(div);
    });
});
