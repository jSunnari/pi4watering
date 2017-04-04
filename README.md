# pi4watering *** (In progress) ***
pi4j-project. (using java to controll the GPIO-ports on rPi)

Turns your raspberry-pi to a watering-system for flower-pots (indoor).

<b>Inside:</b><br/>
Waters every odd day in the morning.<br>
Every even day around 3pm the program checks the weather, if there is less than 50% clouds, it will water that day too.

<b>Balcony:</b><br/>
Waters every day in the morning.<br/>
Every day around 3pm the program checks the weather, if there is less than 50% clouds, it will water then too.<br/>
If it's very cloudy three days in a streak, the program will not water that next day<br/>

<h2>Hardware:</h2>
<ul>
<li>
  Raspberry pi
</li>
<li>
  USB WIFI Dongle
</li>
<li>
  2-channel relay
</li>
<li>
  Water-pump 12v motor
</li>
<li>
  Jumper cables
</li>
<li>
  Power-supply 12v
</li>
<li>
  8mm hose
</li>
</ul>

![wiring](https://cloud.githubusercontent.com/assets/15261370/24668945/cb649e44-1968-11e7-8193-4912d6ba5919.jpg)

<h2>Software:</h2>
<ul>
<li>
  Java
</li>
<li>
  Maven
</li>
<li>
Spring-boot
</li>
<li>
h2 database
</li>
<li>
  HTML
</li>
<li>
  JQuery
</li>
</ul>

Web interface:
![screenshot interface](https://cloud.githubusercontent.com/assets/15261370/24668944/cb4cb20c-1968-11e7-8175-fdca2cacfd36.png)

Testing hardware:
![pi4watering](https://cloud.githubusercontent.com/assets/15261370/24668948/cb6692ee-1968-11e7-8fcf-eaf6710788a9.JPG)

Hardware running:
![pi4watering](https://cloud.githubusercontent.com/assets/15261370/24668947/cb65c27e-1968-11e7-9eac-51f4d49bf262.jpg)

Built hose holder: 
![pi4watering](https://cloud.githubusercontent.com/assets/15261370/24668949/cb690416-1968-11e7-8d89-073310533754.jpg)

On the balcony: 
![pi4watering](https://cloud.githubusercontent.com/assets/15261370/24668946/cb6500d2-1968-11e7-99b8-3c3c8a2e01ec.jpg)
