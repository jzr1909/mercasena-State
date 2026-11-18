# Bitácora de uso de IA — Patrón State

Aprendices: Juan Jose Zuluaga Rincon
Ficha: 3409871  Fecha de inicio: 12/11/2026

> La bitácora es evidencia del ítem 18 de la lista de chequeo. Regístralo **todo**, también las respuestas de la IA que estaban mal.
> Nunca pegues en una IA contraseñas, tokens, datos personales reales ni código que no tengas permiso de compartir.

## 1. Predicción sin IA (máx. 20 minutos)

Antes de abrir cualquier IA, lee el README y el código. Escribe aquí qué errores crees que hay y por qué.

| # | Archivo y línea | ¿Qué creo que está mal? | ¿Qué regla de negocio rompe? |
|---|---|---|---|
| 1 |La clase Enviado en la linea 17 | Aparece que al cancelar un pedido que esta en estado enviado pasa a estar cancelado | La que dice que en especial un pedido enviado no puede ser cancelado ya que va en las manos del transpotador|
| 2 |La clase Pagado en la linea 12 | Cuando llaman al metodo enviar el estado no pasa a estar enviado si no que entregado. | Daña el flujo normal que debe de tener, ya que despues de pagado debe ser pasado a enviado y no a entregado |
| 3 |La clase Pagado en la linea 17 | Esta cancelando un pedido pagado pero no hace activa el reembolso| Rompe la regla que habla de que si un pedido fue pagado pero lo cancelan se debe activar el reembolso pendiente |



## 2. Registro de interacciones con IA

Copia una fila por cada consulta importante.

| # | Herramienta (ChatGPT / Gemini / DeepSeek / Copilot / otra) | Prompt (resumen o enlace) | ¿Qué respondió? | ¿Era correcto? ¿Cómo lo verifiqué? | ¿Lo usé? (sí / no / modificado) |
|---|---|---|---|---|---|
| 1 | | | | | |
| 2 | | | | | |
| 3 | | | | | |

## 3. Jurado de IAs

Envía el **mismo prompt** a tres herramientas distintas y compara.

| Pregunta enviada | ChatGPT | Gemini | DeepSeek | ¿Quién acertó? ¿En qué discreparon? |
|---|---|---|---|---|
| | | | | |

## 4. Errores encontrados y corregidos

| # | Error | Prueba que lo demuestra (nombre del método de prueba) | Commit de la corrección | ¿Lo encontré yo, la IA o ambos? |
|---|---|---|---|---|
| 1 | El estado Pagado saltaba directamente a ENTREGADO en lugar de pasar a ENVIADO.|flujoCompleto |fix(state): transicion corregida de Pagado a Enviado |Yo |
| 2 | | | | |
| 3 | | | | |

## 5. Lo que la IA hizo mal o no vio

Describe por lo menos un caso en que la IA se equivocó, inventó algo o propuso un cambio peligroso. ¿Cómo te diste cuenta?

## 6. Reflexión final (5 a 10 líneas)

¿Qué parte del trabajo aceleró la IA? ¿En qué momento decidiste **no** usarla y por qué? ¿Qué aprendiste del patrón que no sabías antes?
