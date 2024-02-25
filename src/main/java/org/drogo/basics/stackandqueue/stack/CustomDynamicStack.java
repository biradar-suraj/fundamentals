package org.drogo.basics.stackandqueue.stack;

public class CustomDynamicStack extends CustomStack {

    public CustomDynamicStack(int size) {
        super(size);
    }

    public CustomDynamicStack() {
        super();
    }

    @Override
    public boolean push(int item) throws StackException {
        if (this.isFull()) {
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];

            }
            data = temp;
        }

        return super.push(item);
    }
}
