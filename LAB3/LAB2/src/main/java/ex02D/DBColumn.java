package ex02D;

public class DBColumn 
{
    private String colName;
    private String colType; 
    private String isNullable;
    private String isAutoIncrement;
    private int colSize;
    
    protected DBColumn(final String colName, final String colType, final String isNullable, final int colSize, final String isAutoIncrement)
    {
        this.colName = colName;
        this.colType = colType;
        this.isNullable = isNullable;
        this.colSize  =colSize;
        this.isAutoIncrement = isAutoIncrement;
    }
    
    public String toSQL()
    {
        final StringBuffer sb = new StringBuffer();
        sb.append("\n" + this.colName + " " + this.colType);
  
        return sb.toString();
    }

    public String getIsAutoIncrement() {
        return isAutoIncrement;
    }

    public void setIsAutoIncrement(String isAutoIncrement) {
        this.isAutoIncrement = isAutoIncrement;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getIsNullable() {
        return isNullable;
    }
       
    public String getName() {
        return colName;
    }

    public String getColType() 
    {
        return colType;//Convert from SQLType to String
    }

    public void setName(String name) {
        this.colName = name;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }
    
    public String getColName() {
        return colName;
    }

    public int getColSize() {
        return colSize;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public void setColSize(int colSize) {
        this.colSize = colSize;
    }
   
    

    
}
