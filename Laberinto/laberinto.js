const output = document.getElementById("output");
const opcionesDiv = document.getElementById("opciones");
let historia = "";
let paso = 0;

const tecla = new Audio("../Web/assetsss/tecla.mp3");

const preguntas = {
  prehistoria: [
    { texto: "¿Aceptar el rol de chamán para ganar protección?", opciones: ["Sí", "No"] },
    { texto: "¿Revelar tu verdadera identidad al curar al niño?", opciones: ["Sí", "No"] },
    { texto: "¿Usar conocimientos modernos en el ritual de lluvia?", opciones: ["Sí", "No"] },
    { texto: "¿Sacrificar herramientas para apaciguar espíritus?", opciones: ["Sí", "No"] },
    { texto: "¿Unirte a la cacería del mamut pese al riesgo?", opciones: ["Sí", "No"] },
    { texto: "¿Intervenir cuando condenan a un inocente por tu 'profecía'?", opciones: ["Sí", "No"] }
  ],
  futuro: [
    { texto: "¿Ayudar al androide rebelde o reportarlo?", opciones: ["Ayudar", "Reportar"] },
    { texto: "¿Esconderlo en tu casa o llevarlo a un hacker?", opciones: ["Casa", "Hacker"] },
    { texto: "¿Usar la información clasificada o destruirla?", opciones: ["Usar", "Destruir"] },
    { texto: "¿Mentir a la policía de IA o decir la verdad?", opciones: ["Mentir", "Verdad"] },
    { texto: "¿Desconectar al androide o perdonarlo?", opciones: ["Desconectar", "Perdonar"] },
    { texto: "¿Unirse a rebelión de máquinas o buscar vida pacífica?", opciones: ["Rebelión", "Paz"] }
  ]
};

const finales = {
  prehistoria: [
    "Líder espiritual", 
    "Hereje exiliado", 
    "Víctima de tus propias mentiras"
  ],
  futuro: [
    "Fugitivo tecnológico", 
    "Redención cibernética", 
    "Traición artificial"
  ]
};

function escribirTexto(texto, callback) {
  output.innerText = "";
  let i = 0;
  function escribir() {
    if (i < texto.length) {
      output.innerText += texto.charAt(i);
      tecla.currentTime = 0;
      tecla.play();
      i++;
      setTimeout(escribir, 25);
    } else {
      callback?.();
    }
  }
  escribir();
}

function mostrarInicio() {
  escribirTexto("ELIGE UNA ERA PARA COMENZAR TU AVENTURA:\n", () => {
    opcionesDiv.innerHTML = `
      <div class="opciones-iniciales">
        <button onclick="comenzarHistoria('prehistoria')">🌄 PREHISTORIA</button>
        <button onclick="comenzarHistoria('futuro')">🤖 FUTURO</button>
      </div>
    `;
  });
}

function comenzarHistoria(tipo) {
  historia = tipo;
  paso = 0;
  escribirTexto(`HAS ELEGIDO LA ERA ${historia.toUpperCase()}.\n`, () => {
    setTimeout(siguientePregunta, 800);
  });
}

function siguientePregunta() {
  if (paso < preguntas[historia].length) {
    const preguntaActual = preguntas[historia][paso];
    escribirTexto(preguntaActual.texto, () => {
      mostrarOpciones(preguntaActual.opciones);
    });
  } else {
    mostrarFinal();
  }
}

function mostrarOpciones(opciones) {
  let botonesHTML = '<div class="opciones-botones">';
  opciones.forEach(opcion => {
    botonesHTML += `<button onclick="responder('${opcion}')">${opcion}</button>`;
  });
  botonesHTML += '</div>';
  opcionesDiv.innerHTML = botonesHTML;
}

function responder(eleccion) {
  escribirTexto(`\n> ELECCIÓN: ${eleccion.toUpperCase()}`, () => {
    paso++;
    setTimeout(() => {
      output.innerHTML += '<div class="separador"></div>';
      setTimeout(siguientePregunta, 800);
    }, 800);
  });
}

function mostrarFinal() {
  const finalAleatorio = finales[historia][Math.floor(Math.random() * finales[historia].length)];
  escribirTexto(`\n🌀 HAS TERMINADO TU HISTORIA EN LA ERA ${historia.toUpperCase()}.\n\n🏁 FINAL OBTENIDO: ${finalAleatorio.toUpperCase()}`, () => {
    opcionesDiv.innerHTML = `
      <button onclick="mostrarInicio()" style="margin-top: 30px;">
        JUGAR DE NUEVO
      </button>
    `;
  });
}

// Iniciar el juego
mostrarInicio();