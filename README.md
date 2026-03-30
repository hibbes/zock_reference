# zock_reference

Referenzimplementierung der Basisklassen aus dem Buch:

> **Sven Eric Panitz**: *Java will nur spielen — Programmieren lernen mit Spaß und Kreativität*, 2. Auflage, Vieweg+Teubner 2011
> ISBN 978-3-8348-1410-4

Das Projekt deckt **Kapitel 3–5** ab (Teil I: 2D Spiele) und implementiert die Grundbausteine für grafische Spielanwendungen in Java.

## Klassenübersicht

### Kapitel 3 — Spielobjekte

#### Punkte im Raum (Kap. 3.1)
- **`Vertex`** — 2D-Punkt mit Koordinaten `x`, `y`. Methoden: `length()`, `distance()`, `add()`, `addMod()`, `skalarMult()`, `skalarMultMod()`, `normalize()`, `equals()`
- **`TestVertex`** — Testklasse für `Vertex`

#### Geometrische Figuren (Kap. 3.2)
- **`GeometricObject`** — Basisklasse für geometrische Objekte (Position, Breite, Höhe, Farbe). Methoden: `area()`, `circumference()`, `contains()`, `moveTo()`, `move()`
- **`SimpleRectangle`** — Rechteck als `GeometricObject`
- **`SimpleOval`** — Oval als `GeometricObject`
- **`SimpleStar`** — Stern als Polygon
- **`EquilateralTriangle`** — Gleichseitiges Dreieck
- **`TestGeometricObject`** — Testklasse für `GeometricObject`

#### Grafische Darstellung (Kap. 3.3)
- **`Paintable`** — Interface: `paintTo(Graphics g)`
- **`SizedPanel`** / **`SimpleSizedPanel`** — Panel mit fixer Größe
- **`PaintablePanel`** — Panel das ein `Paintable` zeichnet
- **`PaintableOval`** — Zeichenbares Oval
- **`PaintableStar`** — Zeichenbarer Stern
- **`SimplePaintableRectangle`** — Zeichenbares Rechteck
- **`FirstPanel`** — Erstes Demo-Panel

#### Bilder (Kap. 3.4)
- **`MyImage`** — Lädt eine Bilddatei
- **`GeometricImage`** — Bild als `GeometricObject`
- **`PaintableImage`** — Zeichenbares Bild
- **`JFrameTest`** — Zeigt ein Panel in einem JFrame

### Kapitel 5 — Spielfläche (bewegliche Objekte)
- **`GameObject`** — Basisklasse für Spielobjekte
- **`Movable`** — Interface für bewegliche Objekte
- **`MovableImage`** — Bewegliches Bild
- **`MovablePanel`** — Panel mit beweglichen Objekten
- **`PaintablesPanel`** — Panel mit mehreren `Paintable`-Objekten
- **`PaintableArrayPanel`** — Panel mit Array von `Paintable`-Objekten

### Hilfklassen
- **`util/ShowInFrame`** — Zeigt ein beliebiges Panel in einem JFrame-Fenster

## Paketname

Das Paket heißt `name.czernohous.zock_2016` (angepasster Paketname gegenüber dem Buch, das `name.panitz.ludens.animationGame` verwendet).

## Voraussetzungen

- Java 8+
- Eclipse (Projektdateien vorhanden) oder beliebige andere IDE

## Kompilieren und Ausführen

```bash
# Kompilieren
javac -encoding UTF-8 -cp src -d bin $(find src -name "*.java")

# TestVertex ausführen
java -cp bin name.czernohous.zock_2016.TestVertex

# TestGeometricObject ausführen
java -cp bin name.czernohous.zock_2016.TestGeometricObject
```

## Behobene Fehler

| Datei | Problem | Fix |
|---|---|---|
| `Vertex.java` | `addMod(double x, double y)` war wirkungslos — Parameter `x`/`y` überschatteten die Felder `this.x`/`this.y`, Zuweisung landete nie im Objekt | `this.x = this.x + x` statt `x = this.x + x` |
| `SimpleStar.java` | Falsch kodiertes `ö` (ISO-8859-1) im Kommentar verhinderte Kompilierung unter UTF-8 | Zeichen auf UTF-8 korrigiert |
