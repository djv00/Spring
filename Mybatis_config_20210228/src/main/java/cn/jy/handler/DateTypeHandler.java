package cn.jy.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    //将Java类型转换成数据库需要的类型：如String->Varchar
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i,time);
    }
    //将数据库中的类型转换成Java类型
    //String参数     要转换的字段的名称
    //ResultSet     查询出的结果集
    @Override
    public Date getNullableResult(ResultSet resultSet, String i) throws SQLException {
        //获取结果集中需要的数据(long)转换成Date类型返回
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
    //将数据库中的类型转换成Java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
    //将数据库中的类型转换成Java类型
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }





}
