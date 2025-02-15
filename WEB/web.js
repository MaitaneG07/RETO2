document.addEventListener('DOMContentLoaded', function () {

    // Funciones de inicialización y validación
    function iniciarSesion() {
        console.log("Iniciando sesión...");
        var usuarioIngresado = document.getElementById("usuario").value;
        var contrasenaIngresada = document.getElementById("contrasena").value;

        if (!usuarioIngresado || !contrasenaIngresada) {
            alert("Por favor, ingrese usuario y contraseña.");
            return;
        }

        // Simulación de validación (reemplazar con lógica real)
        var usuarioValido = (usuarioIngresado === "usuario" && contrasenaIngresada === "contrasena");

        if (usuarioValido) {
            alert("Inicio de sesión exitoso.");
            window.location.href = "menu.php";
        } else {
            alert("Usuario o contraseña incorrectos.");
        }
    }

    function inicializarCarrusel() {
        var images = document.querySelectorAll('.contenedor_carrusel img');
        var currentIndex = 0;

        function updateImageDisplay() {
            images.forEach((img, i) => {
                img.classList.toggle('active', i === currentIndex);
            });
        }

        function showNextImage(event) {
            if (event) event.preventDefault();
            currentIndex = (currentIndex + 1) % images.length;
            updateImageDisplay();
        }

        function showPreviousImage(event) {
            if (event) event.preventDefault();
            currentIndex = (currentIndex - 1 + images.length) % images.length;
            updateImageDisplay();
        }

        updateImageDisplay();

        var nextButton = document.querySelector('.flecha.siguiente');
        var prevButton = document.querySelector('.flecha.anterior');

        if(nextButton && prevButton){
            nextButton.addEventListener('click', showNextImage);
            prevButton.addEventListener('click', showPreviousImage);
        }

    }

    // Event listeners generales
    var botonLogin = document.getElementById("btnLogin");
    if (botonLogin) {
        botonLogin.addEventListener("click", iniciarSesion);
    }

    if (window.location.pathname.includes("menu")) {
        inicializarCarrusel();
    }



    function validarFechasYCalcularDias() {
        var fechaEntrada = document.getElementById("fecha_entrada");
        var fechaSalida = document.getElementById("fecha_salida");
        var diasInput = document.getElementById("dias");
        
        if (fechaEntrada && fechaSalida && diasInput) {
            var inicio = new Date(fechaEntrada.value);
            var fin = new Date(fechaSalida.value);
            
            if (fechaEntrada.value && fechaSalida.value) {
                if (fin <= inicio) {
                    alert("La fecha de salida debe ser posterior a la fecha de entrada.");
                    fechaSalida.value = "";
                    diasInput.value = "";
                } else {
                    var diff = (fin - inicio) / (1000 * 60 * 60 * 24);
                    diasInput.value = diff;
                }
            }
        }
    }

    var fechaEntrada = document.getElementById("fecha_entrada");
    var fechaSalida = document.getElementById("fecha_salida");
    if (fechaEntrada && fechaSalida) {
        fechaEntrada.addEventListener("change", validarFechasYCalcularDias);
        fechaSalida.addEventListener("change", validarFechasYCalcularDias);
    }

    function inicializarSelectorOpciones() {
        var radiosServicio = document.querySelectorAll('input[name="tipo_servicio"]');
        var seccionVuelo = document.getElementById("seccion_vuelo");
        var seccionHotel = document.getElementById("seccion_hotel");
        var seccionOtros = document.getElementById("seccion_otros");
        var seccionIda = document.getElementById("seccion_ida");
        var seccionVuelta = document.getElementById("seccion_vuelta");
        var radiosTipoVuelo = document.querySelectorAll('input[name="tipo_vuelo"]');

        // Función para mostrar/ocultar secciones de vuelo (ida/ida-vuelta)
        function mostrarSeccionesVuelo(tipoVuelo) {
            if (seccionIda) seccionIda.style.display = 'none';
            if (seccionVuelta) seccionVuelta.style.display = 'none';

            if (tipoVuelo === 'vuelo_ida' && seccionIda) {
                seccionIda.style.display = 'block';
            } else if (tipoVuelo === 'vuelo_idaVuelta' && seccionIda && seccionVuelta) {
                seccionIda.style.display = 'block';
                seccionVuelta.style.display = 'block';
            }
        }
        // Event listener para el tipo de vuelo (ida/ida-vuelta)
        radiosTipoVuelo.forEach(function (radio) {
            radio.addEventListener("change", function () {
                mostrarSeccionesVuelo(this.value);
            });
        });

        // Event listener para el tipo de servicio (vuelo, hotel, otros)
        radiosServicio.forEach(function (radio) {
            radio.addEventListener("change", function () {
                if (seccionVuelo) seccionVuelo.style.display = "none";
                if (seccionHotel) seccionHotel.style.display = "none";
                if (seccionOtros) seccionOtros.style.display = "none";
                if (seccionIda) seccionIda.style.display = "none";
                if (seccionVuelta) seccionVuelta.style.display = "none";

                if (this.value === "vuelo" && seccionVuelo) {
                    seccionVuelo.style.display = "block";
                    // Al mostrar la sección de vuelo, inicializar las secciones de ida/ida-vuelta
                    mostrarSeccionesVuelo(document.querySelector('input[name="tipo_vuelo"]:checked') ? document.querySelector('input[name="tipo_vuelo"]:checked').value : null);
                } else if (this.value === "hotel" && seccionHotel) {
                    seccionHotel.style.display = "block";
                } else if (this.value === "otros" && seccionOtros) {
                    seccionOtros.style.display = "block";
                }
            });
        });

        // Inicializar ocultando las secciones de vuelo al cargar la página
        if (seccionVuelo) seccionVuelo.style.display = "none";
        if (seccionHotel) seccionHotel.style.display = "none";
        if (seccionOtros) seccionOtros.style.display = "none";
        if (seccionIda) seccionIda.style.display = "none";
        if (seccionVuelta) seccionVuelta.style.display = "none";
    }

        if (window.location.pathname.includes("zerbitzuak")) {
            inicializarSelectorOpciones();
        }
});