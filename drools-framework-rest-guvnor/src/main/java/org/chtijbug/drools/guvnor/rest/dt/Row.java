package org.chtijbug.drools.guvnor.rest.dt;

import org.chtijbug.drools.guvnor.rest.ChtijbugDroolsRestException;
import org.drools.ide.common.client.modeldriven.dt52.DTCellValue52;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private DecisionTable decisionTable;
    private List<RowElement> rowElements = new ArrayList<RowElement>();
    private List<DTCellValue52> cellValue52List;


    protected Row(DecisionTable decisionTable, int rowNumber) throws ChtijbugDroolsRestException {
        this.decisionTable = decisionTable;
        this.cellValue52List = new ArrayList<DTCellValue52>();
        for (ColumnDefinition col : this.decisionTable.getColumnDefinitionList()) {
            RowElement newRowElement = new RowElement(col);
            this.cellValue52List.add(newRowElement.getDtCellValue52());
            if (col.getColumnNumber() == 0) {
                try {
                    String newString =  String.valueOf(rowNumber);
                    newRowElement.setValue(newString);
                } catch (Exception e) {
                    ChtijbugDroolsRestException chtijbugDroolsRestException = new ChtijbugDroolsRestException(e);
                    chtijbugDroolsRestException.setClassName("Row");
                    chtijbugDroolsRestException.setValue(decisionTable.toString());
                    chtijbugDroolsRestException.setAttribute("protected Row(DecisionTable decisionTable,int rowNumber) throws ChtijbugDroolsRestException");
                    throw chtijbugDroolsRestException;
                }
            }
            this.addRowElement(newRowElement);
        }


    }

    protected Row(List<DTCellValue52> cellValue52List, DecisionTable decisionTable) throws ChtijbugDroolsRestException {
        this.decisionTable = decisionTable;
        this.cellValue52List = cellValue52List;
        for (ColumnDefinition col : this.decisionTable.getColumnDefinitionList()) {
            RowElement newRowElement = new RowElement(col, cellValue52List.get(col.getColumnNumber()));
            this.addRowElement(newRowElement);
        }
    }

    protected void updateRowNumber(int newRowNumber) throws ChtijbugDroolsRestException {
        RowElement rowNumberElement = rowElements.get(0);
        try {
            rowNumberElement.setValue(String.valueOf(newRowNumber));
        } catch (Exception e){
            ChtijbugDroolsRestException chtijbugDroolsRestException = new ChtijbugDroolsRestException(e);
            chtijbugDroolsRestException.setAttribute("protected void updateRowNumber(int newRowNumber) throws ChtijbugDroolsRestExceptio");
            chtijbugDroolsRestException.setClassName("Row");
            throw chtijbugDroolsRestException;
        }
    }

    public List<RowElement> getRowElements() {
        return rowElements;
    }

    public void addRowElement(RowElement newRowElement) {
        this.rowElements.add(newRowElement);
    }

    public List<DTCellValue52> getCellValue52List() {
        return cellValue52List;
    }
}
