# zock_reference

Vollständige Referenzimplementierung der Framework-Klassen aus dem Buch:

> **Sven Eric Panitz**: *Java will nur spielen – Programmieren lernen mit Spaß und Kreativität*, 2. Aufl., Vieweg+Teubner 2011  
> Kapitel 3–5 (Teil I: 2D-Spiele)

Dieses Repo enthält die kanonische, paketverwaltete Implementierung im Package `name.czernohous.zock_2016`.  
Für Unterrichtszwecke steht die vereinfachte Version ohne Packages in **`JavaWillNurSpielen`** bereit.

## Packages und Klassen

Alle Klassen befinden sich in `src/name/czernohous/zock_2016/`:

| Klasse | Beschreibung |
|--------|-------------|
| `Vertex` | 2D-Punkt/Vektor |
| `GeometricObject` | Basisklasse: Position, Größe, Kollision |
| `SimpleOval` | Ellipse |
| `SimpleRectangle` | Rechteck |
| `SimpleSizedPanel` | Panel mit fester Größe |
| `PaintableOval` | Oval + `paintTo()` |
| `PaintablePanel` | Panel mit Zeichenliste |
| `PaintablesPanel` | Panel mit mehreren Paintables |
| `MovablePanel` | Spielschleife mit Bewegung |
| `MovableImage` / `PaintableImage` | Bilder als Spielobjekte |
| `PaintableStar` / `SimpleStar` | Sternformen |
| `EquilateralTriangle` | Gleichseitiges Dreieck |
| `Paintable` / `Movable` / `GameObject` | Interfaces |
| `JFrameTest` / `FirstPanel` | Test- und Demo-Klassen |

## Unterschied zu JavaWillNurSpielen

| Merkmal | `zock_reference` | `JavaWillNurSpielen` |
|---------|-----------------|---------------------|
| Package | `name.czernohous.zock_2016` | default package |
| Vollständigkeit | alle Klassen aus Kap. 3–5 | Auswahl der wichtigsten |
| Verwendung | Referenz / Vorlage | Unterricht / Einstieg |
