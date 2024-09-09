document.addEventListener('DOMContentLoaded', () => {
    console.log('Archivo cliente.js cargado');

    const createClientesForm = document.getElementById('createClientesForm');
    const searchClientesForm = document.getElementById('searchClientesForm');
    const updateClientesForm = document.getElementById('updateClientesForm');
    const deleteClientesForm = document.getElementById('deleteClientesForm');
    const clientesListContainer = document.getElementById('clientesList');

    if (createClientesForm) {
        createClientesForm.addEventListener('submit', async (event) => {
            event.preventDefault();
            const formData = new FormData(createClientesForm);
            const data = Object.fromEntries(formData.entries());

            try {
                const response = await fetch('/api/clientes', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify(data),
                });

                if (response.ok) {
                    alert('Cliente creada exitosamente');
                    createClientesForm.reset();
                    const modal = bootstrap.Modal.getInstance(document.getElementById('createModal'));
                    modal.hide();
                } else {
                    alert('Error al crear cliente');
                }
            } catch (error) {
                console.error('Error:', error);
                alert('Error de red');
            }
        });
    }

    if (searchClientesForm) {
        searchClientesForm.addEventListener('submit', async (event) => {
            event.preventDefault();
            const clientesId = document.getElementById('searchId').value;

            try {
                const response = await fetch(`/api/clientes/${clientesId}`);
                if (response.ok) {
                    const clientes = await response.json();
                    document.getElementById('clientesId').textContent = clientes.id;
                    document.getElementById('clientesName').textContent = clientes.name;
                    document.getElementById('clientesDescription').textContent = clientes.description;
                } else {
                    alert('Cliente no encontrada');
                }
            } catch (error) {
                console.error('Error:', error);
                alert('Error de red');
            }
        });
    }

    if (updateClientesForm) {
        updateClientesForm.addEventListener('submit', async (event) => {
            event.preventDefault();
            const formData = new FormData(updateClientesForm);
            const data = Object.fromEntries(formData.entries());
            const clientesId = data.id;

            try {
                const response = await fetch(`/api/clientes/${clientesId}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        name: data.name,
                        description: data.description,
                    }),
                });

                if (response.ok) {
                    alert('Cliente actualizada exitosamente');
                    updateClientesForm.reset();
                    const modal = bootstrap.Modal.getInstance(document.getElementById('updateModal'));
                    modal.hide();
                } else {
                    alert('Error al actualizar cliente');
                }
            } catch (error) {
                console.error('Error:', error);
                alert('Error de red');
            }
        });
    }

    if (deleteClientesForm) {
        deleteClientesForm.addEventListener('submit', async (event) => {
            event.preventDefault();
            const clientesId = document.getElementById('deleteId').value;

            try {
                const response = await fetch(`/api/clientes/${clientesId}`, {
                    method: 'DELETE',
                });

                if (response.ok) {
                    alert('Cliente eliminada exitosamente');
                    deleteClientesForm.reset();
                    const modal = bootstrap.Modal.getInstance(document.getElementById('deleteModal'));
                    modal.hide();
                } else {
                    alert('Error al eliminar cliente');
                }
            } catch (error) {
                console.error('Error:', error);
                alert('Error de red');
            }
        });
    }

    // Funcionalidad para listar clientes
    document.querySelector('[data-bs-target="#listModal"]').addEventListener('click', async () => {
        try {
            const response = await fetch('/api/clientes');
            if (response.ok) {
                const clientes = await response.json();
                if (clientes.length === 0) {
                    clientesListContainer.innerHTML = '<p>No hay clientes disponibles.</p>';
                } else {
                    const listHtml = clientes.map(clientes => `
                        <div class="clientes-item mb-3">
                            <p><strong>ID:</strong> ${clientes.id}</p>
                            <p><strong>Nombre:</strong> ${clientes.name}</p>
                            <p><strong>Descripción:</strong> ${clientes.description}</p>
                            <button class="btn btn-primary btn-sm me-2" data-action="update" data-id="${clientes.id}">Actualizar</button>
                            <button class="btn btn-danger btn-sm" data-action="delete" data-id="${clientes.id}">Eliminar</button>
                            <hr>
                        </div>
                    `).join('');
                    clientesListContainer.innerHTML = listHtml;
                }
            } else {
                clientesListContainer.innerHTML = '<p>Error al cargar clientes.</p>';
            }
        } catch (error) {
            console.error('Error:', error);
            clientesListContainer.innerHTML = '<p>Error de red.</p>';
        }
    });

    // Manejo de clics en los botones de actualizar y eliminar en el modal de listar
    clientesListContainer.addEventListener('click', async (event) => {
        const button = event.target;
        if (button.tagName === 'BUTTON') {
            const action = button.getAttribute('data-action');
            const clientesId = button.getAttribute('data-id');

            if (action === 'update') {
                // Rellenar el formulario de actualización con los datos de la cliente
                const response = await fetch(`/api/clientes/${clientesId}`);
                if (response.ok) {
                    const clientes = await response.json();
                    document.getElementById('updateId').value = clientes.id;
                    document.getElementById('updateName').value = clientes.name;
                    document.getElementById('updateDescription').value = clientes.description;
                    const updateModal = new bootstrap.Modal(document.getElementById('updateModal'));
                    updateModal.show();
                } else {
                    alert('Error al cargar datos de la cliente');
                }
            } else if (action === 'delete') {
                document.getElementById('deleteId').value = clientesId;
                const deleteModal = new bootstrap.Modal(document.getElementById('deleteModal'));
                deleteModal.show();
            }
        }
    });
});
