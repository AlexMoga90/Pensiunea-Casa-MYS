document.addEventListener('DOMContentLoaded', function () {
    fetch('/api/users', {
        headers: { 'Authorization': `Bearer ${localStorage.getItem('token')}` }
    })
        .then(response => response.json())
        .then(users => {
            const container = document.getElementById('usersContainer');
            users.forEach(user => {
                const div = document.createElement('div');
                div.classList.add('user');
                div.innerHTML = `<p>${user.username} - ${user.role}</p>`;
                container.appendChild(div);
            });
        });
});
