document.addEventListener("DOMContentLoaded", function() {
    const rezervareForm = document.getElementById("rezervare-form");

    rezervareForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const token = localStorage.getItem("token");

        if (!token) {
            alert("Trebuie să fii autentificat pentru a face o rezervare!");
            return;
        }

        const numarCamera = document.getElementById("numar-camera").value;
        const response = await fetch("http://localhost:8080/api/rezervari", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${token}`
            },
            body: JSON.stringify({ numarCamera }),
        });

        if (response.ok) {
            alert("Rezervare efectuată cu succes!");
        } else {
            alert("Eroare la rezervare!");
        }
    });
});
