package DrunkardGame.GameObjects.CommonObjects;

import DrunkardGame.GameObjects.StaticObjects.Border;

/**
 * Created by novokrest on 3/3/14.
 */
public class Field {
    int rowCount;
    int columnCount;
    GameObject[][] tableObjects;

    public Field(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        tableObjects = new GameObject[this.rowCount][this.columnCount];

        for (int i = 0; i < this.rowCount; i++) {
            for (int j = 0; j < this.columnCount; j++) {
                if ((i == 0) || (i == this.rowCount - 1) || (j == 0) || (j == this.columnCount - 1)) {
                    tableObjects[i][j] = new Border(i, j);
                }
                else {
                    tableObjects[i][j] = new GameObject(i, j);
                }
            }
        }
    }

    public int getRowCount() { return rowCount; }
    public int getColumnCount() { return columnCount; }

    public GameObject getObject(int coordinateX, int coordinateY) {
        return tableObjects[coordinateX][coordinateY];
    }

    public void register(GameObject gameObject) {
        tableObjects[gameObject.getX()][gameObject.getY()] = gameObject;
    }

    public void unregister(Coordinates coordinates) {
        tableObjects[coordinates.getX()][coordinates.getY()] = new GameObject(coordinates.getX(), coordinates.getY());
    }

    public void swapGameObject(Coordinates coordinates1, Coordinates coordinates2) {
        GameObject tmp = getObject(coordinates1);
        tableObjects[coordinates1.getX()][coordinates1.getY()] = getObject(coordinates2);
        tableObjects[coordinates2.getY()][coordinates2.getY()] = tmp;
    }

    public void print() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                tableObjects[j][i].print();
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
