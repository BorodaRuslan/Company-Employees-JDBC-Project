package org.example.app.view.filtering;
public class EmployeeFilterByPositionView extends EmployeeFilterAbstractView {
    @Override
    public void getOutput(String output) {
        if (output.isEmpty()){
            System.out.println("No positions selected.");
        } else {
            String positionsStr = String.join(",", filterList);
            System.out.println("You have filtered these positions: " + positionsStr);
            System.out.println(output);
        }

    }
}
