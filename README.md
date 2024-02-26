# Análisis del problema

#### Dada una correspondencia entre letras y números, y un mensaje numérico codificado:
#### se desea contar el número de maneras en que se puede decodificar el mensaje.

# Pseudocódigo

### El algoritmo para contar el número de maneras de decodificar un mensaje numérico es el siguiente:

      Recorrer el mensaje numérico caracter a caracter.
        Para cada caracter:
        Obtener la lista de letras que corresponden al caracter.
        Para cada letra:
          Si la letra es el primer caracter del mensaje:
            Aumentar el contador de maneras en 1.
          Si la letra no es el primer caracter del mensaje:
          Si la letra anterior es compatible con la letra actual:
            Aumentar el contador de maneras en el número de maneras de decodificar el submensaje que comienza en la posición actual.
            Devolver el contador de maneras.
