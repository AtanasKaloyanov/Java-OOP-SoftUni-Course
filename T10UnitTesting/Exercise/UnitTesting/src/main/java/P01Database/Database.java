package P01Database;

import javax.naming.OperationNotSupportedException;

public class Database {
    private Integer[] elements;
    private int elementsCount;
    private int index;

    public Database(Integer... elements) throws OperationNotSupportedException {
        this.setElements(elements);
        this.elementsCount = elements.length;
        this.index = this.elementsCount - 1;
    }

    public Integer[] getElements() {
        Integer[] buffer = new Integer[this.elementsCount];
        int bufferIndex = 0;

        for (Integer element : this.elements) {
            if (element != null) {
                buffer[bufferIndex++] = element;
            }
        }

        return buffer;
    }

    private void setElements(Integer... elements) throws OperationNotSupportedException {
        if (elements.length > 16 || elements.length < 1) {
            throw new OperationNotSupportedException();
        }

        this.elements = new Integer[16];
        int bufferIndex = 0;

        for (Integer element : elements) {
            this.elements[bufferIndex++] = element;
        }

        this.index = elements.length - 1;
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
        }

        this.elements[++this.index] = element;
        this.elementsCount++;
    }

    public void remove() throws OperationNotSupportedException {
		try {
			this.elements[this.index--] = null;
			this.elementsCount--;			
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new OperationNotSupportedException();
		}
    }

}
