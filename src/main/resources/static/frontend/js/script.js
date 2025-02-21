document.addEventListener('DOMContentLoaded', function () {
    const token = localStorage.getItem('token');
    const loginLink = document.getElementById('loginLink');
    const logoutLink = document.getElementById('logoutLink');
    const userInfo = document.getElementById('userInfo');
    const usernameSpan = document.getElementById('username');

    if (token) {
        fetch('/api/auth/me', {
            headers: { 'Authorization': `Bearer ${token}` }
        }).then(response => response.json())
            .then(user => {
                if (user.username) {
                    userInfo.style.display = 'block';
                    usernameSpan.textContent = user.username;
                    loginLink.style.display = 'none';
                    logoutLink.style.display = 'inline';
                }
            });
    }

    logoutLink.addEventListener('click', function () {
        localStorage.removeItem('token');
        window.location.reload();
    });
});
