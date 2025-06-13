const output = document.getElementById("output");
const opcionesDiv = document.getElementById("opciones");
let historia = "";
let paso = 0;

const tecla = new Audio("../Web/assetsss/tecla.mp3");

const preguntas = {
  prehistoria: [
    {
      texto: "Un miembro de la tribu afirma haber tenido una visión que contradice tus conocimientos del futuro. ¿Lo desacreditas públicamente o respetas su visión?",
      opciones: ["Desacreditar", "Respetar"]
    },
    {
      texto: "Descubres una planta con propiedades curativas. ¿La compartes con todos o solo con los líderes?",
      opciones: ["Compartir", "Solo líderes"]
    },
    {
      texto: "Una caza peligrosa se avecina y sabes que acabará en tragedia. ¿Intervienes para evitarla aunque rompas tradiciones?",
      opciones: ["Intervenir", "Callar"]
    },
    {
      texto: "El chamán te ofrece enseñarte su sabiduría ancestral. ¿Aceptas aprender su visión del mundo, aunque se oponga a tu lógica?",
      opciones: ["Aceptar", "Rechazar"]
    },
    {
      texto: "Encuentras una pintura rupestre que describe tu llegada. ¿La destruyes para proteger el tiempo o la preservas como testimonio?",
      opciones: ["Destruir", "Preservar"]
    }
  ],
  futuro: [
    {
      texto: "Una IA ha empezado a cuestionar las órdenes humanas. ¿La ayudas a escapar o alertas al sistema?",
      opciones: ["Ayudar", "Alertar"]
    },
    {
      texto: "Te ofrecen un implante que incrementa tu inteligencia, pero reduce tus emociones. ¿Lo aceptas?",
      opciones: ["Aceptar", "Rechazar"]
    },
    {
      texto: "Descubres que tu jefe manipula recuerdos en trabajadores. ¿Lo enfrentas o lo chantajeas?",
      opciones: ["Enfrentar", "Chantajear"]
    },
    {
      texto: "Un niño humano ha sido criado por androides y no distingue la diferencia. ¿Le dices la verdad?",
      opciones: ["Decir verdad", "Mentir"]
    },
    {
      texto: "Debes elegir entre salvar una ciudad del colapso energético o liberar datos que podrían derrocar al gobierno. ¿Qué haces?",
      opciones: ["Salvar ciudad", "Liberar datos"]
    }
  ]
};

const finales = {
  prehistoria: [
    "Elegido por los dioses: la tribu te venera como un puente entre mundos.",
    "Exiliado del tiempo: descubren tu origen y eres desterrado para siempre.",
    "Sabio silencioso: influencias desde las sombras, cambiando la historia sin dejar rastro."
  ],
  futuro: [
    "Arquitecto del mañana: diseñas una nueva era entre humanos y máquinas.",
    "Prisionero de conciencia: tus decisiones fueron justas, pero pagas el precio.",
    "Revolucionario anónimo: liberas al sistema, pero el mundo nunca sabrá tu nombre."
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
      window.scrollTo({ top: document.body.scrollHeight, behavior: "smooth" });
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
    window.scrollTo({ top: document.body.scrollHeight, behavior: "smooth" });
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
  window.scrollTo({ top: document.body.scrollHeight, behavior: "smooth" });
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
        🔁 JUGAR DE NUEVO
      </button>
    `;
    window.scrollTo({ top: document.body.scrollHeight, behavior: "smooth" });
  });
}

// Iniciar el juego
mostrarInicio();
