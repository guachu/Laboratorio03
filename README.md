**Part I - Introduction to threads in JAVA**

Change the beginning with start() to run(). How does the output change? Why?
La diferencia en aplicar el Start o el run es que al aplicar solo en run inicia el thread sin importar los pasos anteriores de la iniciacion
en cambio si se inicia con el Start el thread se va a iniciar completamente cumpliendo el orden de un thread

**Part III - Discussion**

How could the implementation be modified to minimize the number of queries in these cases?
Lo que modificariamos seria agregar un valor global el cual se encargue de llevar el conteo de las ocurrencias y asi cuando llegue al minimo
se detengan todos los threads
What new element would this bring to the problem?
El problema seria que no se podria confirmar adecuadamente que el valor que este en esta variable se adecuado.

**Part IV - Performance Evaluation** 

A single thread Time = 112.997
As many threads as processing cores (have the program determine this using the Runtime API). Time: 66.06
As many threads as twice the number of processing cores. Time: 30.015
50 threads Time: 1.958
100 threads Time: 0.941

**1 thread**
![](images/Imagen1.png)
![](images/imagen2.png)

**2 threads**
![](images/imagen3.png)
![](images/imagen4.png)

**4 threads** 
![](images/imagen5.png)
![](images/imagen6.png)

**50 threads** 
![](images/imagen7.png)
![](images/imagen8.png)
![](images/imagen9.png)

**100 threads**
![](images/imagen10.png)
![](images/imagen11.png)
