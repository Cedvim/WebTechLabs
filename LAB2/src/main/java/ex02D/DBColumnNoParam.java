package ex02D;

public class DBColumnNoParam extends DBColumn {
	//Column with no param
    protected DBColumnNoParam(final String colName, final String colType, final String isNullable, final int colSize, final String isAutoIncrement) {
        super(colName, colType, isNullable, colSize, isAutoIncrement);   
    }

    //Conversion to sql instructions of the double param column
    @Override
    public String toSQL() {
    	
        final StringBuffer sb = new StringBuffer();
        sb.append(String.format("\n%s %s %s%s,", this.getName(), this.getColType(), this.getIsNullable(), this.getIsAutoIncrement()));

        return sb.toString();
    }
}