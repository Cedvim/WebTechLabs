package ex02D;

public class DBColumnSingleParam extends DBColumn {
	
	//Column with one param
    protected DBColumnSingleParam(final String colName, final String colType, final String isNullable, final int colSize, final String isAutoIncrement) {
        super(colName, colType, isNullable, colSize, isAutoIncrement);   
    }

    //Conversion to sql instructions of the double param column
    @Override
    public String toSQL() {
    	
        final StringBuffer sb = new StringBuffer();
        sb.append(String.format("\n%s %s(%d) %s%s,", this.getColName(), this.getColType(), this.getColSize(), this.getIsNullable(), this.getIsAutoIncrement()));

        return sb.toString();
    }
}
