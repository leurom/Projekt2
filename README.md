# Einleitung
Dieses Raspberry Pi-Projekt kombiniert Bilderkennung und Wetterdaten, um sicherzustellen, dass du stets angemessen für das Wetter gekleidet bist. Die Anwendung verwendet eine Kamera, ein Image Classification-Modell und ein Node-RED-Dashboard, um die erkannte Kleidung sowie aktuelle Wetterinformationen anzuzeigen.

# Funktionen
Kleidererkennung: Die Kamera erfasst Bilder der getragenen Kleidung, und ein Image Classification-Modell analysiert die Bilder, um die Art der Kleidung zu identifizieren.

Wetterdaten: Die Anwendung verwendet Wetterdaten, um zu bestimmen, welcher Kleidungsstil für die aktuellen Wetterbedingungen angemessen ist.

Node-RED Dashboard: Die erkannte Kleidung und die Wetterinformationen werden in einem übersichtlichen Node-RED-Dashboard dargestellt.

# installation
Raspberry Pi Setup: Stelle sicher, dass dein Raspberry Pi ordnungsgemäß eingerichtet ist und die Kamera korrekt angeschlossen ist.

Virtual environment einrichten und den Projektordner anschliessend darin einfügen:
$ sudo pip install virtualenv
$ virtualenv [nameofvenv]
$ cd [nameofvenv]
$ source bin/activate

Abhängigkeiten installieren: Führe das Skript zur Installation der erforderlichen Abhängigkeiten aus. Dies kann beispielsweise OpenCV, TensorFlow und andere Python-Bibliotheken umfassen.

$ pip install -r requirements.txt

Node-RED einrichten: Konfiguriere Node-RED auf deinem Raspberry Pi und importiere das bereitgestellte Flow-Skript für das Dashboard.
Node-RED: v3.0.2
Node.js: v16.18.1
npm: 8.19.2

Installation der LTS (long term support) Version inklusive Node.js und npm (empfohlen!!!)
bash <(curl -sL https://raw.githubusercontent.com/node-red/linux-installers/master/deb/update-nodejs-and-nodered)

Node-Red starten:
$ node-red-start

Anwendung starten.
$ python classify.py

 




 
 
