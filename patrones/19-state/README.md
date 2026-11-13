# MercaSENA · Patrón State (Comportamiento)

**Dominio:** Ciclo de vida de un pedido

## Contexto

Un pedido de MercaSENA pasa por varios estados: **PENDIENTE**, **PAGADO**, **ENVIADO**, **ENTREGADO** o **CANCELADO**. Lo que se puede hacer depende del estado: no se puede enviar un pedido sin pagar ni cancelar uno que ya va en camino. En lugar de llenar `Pedido` de `if (estado == ...)`, el patrón **State** pone cada comportamiento en una clase de estado.

Clases principales:

- `Pedido`: contexto.
- `EstadoPedido`: interfaz de estado. `EstadoBase` implementa por defecto el rechazo de todas las acciones.
- `Pendiente`, `Pagado`, `Enviado`, `Entregado` y `Cancelado`: estados concretos.

## Reglas de negocio

1. **Transiciones permitidas:**
   - PENDIENTE → pagar → PAGADO
   - PENDIENTE → cancelar → CANCELADO
   - PAGADO → enviar → ENVIADO
   - PAGADO → cancelar → CANCELADO, y **se marca un reembolso pendiente** porque el cliente ya pagó.
   - ENVIADO → entregar → ENTREGADO
2. **Cualquier otra transición** lanza `IllegalStateException`. En particular, **un pedido ENVIADO no se puede cancelar**, porque ya está en manos del transportador.
3. ENTREGADO y CANCELADO son estados finales.
4. El pedido guarda el historial de los estados por los que pasó.

## Tu misión

Este proyecto implementa el patrón **State** dentro de la tienda en línea **MercaSENA**. El código *compila*, pero tiene **errores sembrados**: algunos los detectan las pruebas que ya existen y otros **no**. Tu trabajo es encontrarlos todos, demostrarlos con pruebas y corregirlos con ayuda de la IA, sin perder el control técnico.

> La fuente de verdad son las **reglas de negocio** de este README. La IA no las conoce si no se las das.

## Protocolo de trabajo (obligatorio)

1. **Prepara el repositorio.** Crea un repositorio en GitHub con este proyecto y haz el primer commit sin cambios: `git commit -m "chore: estado inicial"`.
2. **Predice sin IA (20 min).** Lee este README y el código. Escribe tus hipótesis en `BITACORA_IA.md`, sección 1.
3. **Ejecuta las pruebas.** Corre `mvn test` o las pruebas desde IntelliJ / Eclipse. Anota cuáles fallan.
4. **Demuestra cada error con una prueba.** Por cada error que encuentres, incluidos los que las pruebas actuales no detectan, escribe primero una prueba que **falle**. Haz commit: `test: demuestra <error>`.
5. **Consulta al jurado de IAs.** Envía el mismo prompt a ChatGPT, Gemini y DeepSeek. Usa el prompt de 5 piezas: contexto, tarea, restricciones, formato y criterio de verificación. Registra en la bitácora en qué coincidieron y en qué no.
6. **Corrige.** Aplica la corrección que **tú** entiendes y puedes explicar. La prueba debe pasar. Haz commit: `fix: corrige <error>`.
7. **Refactoriza con IA.** Pide a la IA una mejora de legibilidad que no cambie el comportamiento. Todas las pruebas deben seguir en verde. Haz commit: `refactor: ...`.
8. **Revisa la seguridad.** Pregúntate qué podría hacer un usuario malicioso con este código y anota tu respuesta en la bitácora.
9. **Prepara la defensa.** El instructor te pedirá explicar, **sin IA**, cualquier línea que hayas cambiado.

## Cómo ejecutar

```bash
mvn test
```

Requisitos: JDK 17 o superior y Maven 3.9 o superior, o el Maven que trae IntelliJ IDEA o Eclipse.

## Qué NO hacer

- No borres ni debilites pruebas para que pasen.
- No pegues el proyecto completo en una IA sin explicarle las reglas de negocio.
- No aceptes una corrección que no sabes explicar.

## Referencia del patrón

- https://refactoring.guru/es/design-patterns/state
