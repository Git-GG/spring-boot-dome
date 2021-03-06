package com.feng.product.mapper;

import com.feng.product.model.TbProductAttributes;
import com.feng.product.model.TbProductAttributesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbProductAttributesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    long countByExample(TbProductAttributesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    int deleteByExample(TbProductAttributesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer productAttributesId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    int insert(TbProductAttributes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    int insertSelective(TbProductAttributes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    TbProductAttributes selectOneByExample(TbProductAttributesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    TbProductAttributes selectOneByExampleSelective(@Param("example") TbProductAttributesExample example, @Param("selective") TbProductAttributes.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<TbProductAttributes> selectByExampleSelective(@Param("example") TbProductAttributesExample example, @Param("selective") TbProductAttributes.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    List<TbProductAttributes> selectByExample(TbProductAttributesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    TbProductAttributes selectByPrimaryKeySelective(@Param("productAttributesId") Integer productAttributesId, @Param("selective") TbProductAttributes.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    TbProductAttributes selectByPrimaryKey(Integer productAttributesId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbProductAttributes record, @Param("example") TbProductAttributesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbProductAttributes record, @Param("example") TbProductAttributesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbProductAttributes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_product_attributes
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TbProductAttributes record);
}