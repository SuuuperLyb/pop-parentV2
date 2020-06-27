package com.offway.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LYB
 * @since 2020-06-25
 */
public class TSectype extends Model<TSectype> {

    private static final long serialVersionUID = 1L;

    /**
     * 二级分类id
     */
    @TableId(value = "t_sectype_id", type = IdType.AUTO)
    private Integer tSectypeId;

    /**
     * 二级分类名称
     */
    private String tSectypeName;

    /**
     * 所属一级分类id
     */
    private String tFirsttypeId;

    /**
     * 商品二级分类照片
     */
    private String tSectypePic;

    /**
     * 种类描述 
     */
    private String tSectypeDescription;

    /**
     * 1有效0无效
     */
    private Integer tSectypeIsvalid;

    public Integer gettSectypeId() {
        return tSectypeId;
    }

    public void settSectypeId(Integer tSectypeId) {
        this.tSectypeId = tSectypeId;
    }
    public String gettSectypeName() {
        return tSectypeName;
    }

    public void settSectypeName(String tSectypeName) {
        this.tSectypeName = tSectypeName;
    }
    public String gettFirsttypeId() {
        return tFirsttypeId;
    }

    public void settFirsttypeId(String tFirsttypeId) {
        this.tFirsttypeId = tFirsttypeId;
    }
    public String gettSectypePic() {
        return tSectypePic;
    }

    public void settSectypePic(String tSectypePic) {
        this.tSectypePic = tSectypePic;
    }
    public String gettSectypeDescription() {
        return tSectypeDescription;
    }

    public void settSectypeDescription(String tSectypeDescription) {
        this.tSectypeDescription = tSectypeDescription;
    }
    public Integer gettSectypeIsvalid() {
        return tSectypeIsvalid;
    }

    public void settSectypeIsvalid(Integer tSectypeIsvalid) {
        this.tSectypeIsvalid = tSectypeIsvalid;
    }

    @Override
    protected Serializable pkVal() {
        return this.tSectypeId;
    }

    @Override
    public String toString() {
        return "TSectype{" +
            "tSectypeId=" + tSectypeId +
            ", tSectypeName=" + tSectypeName +
            ", tFirsttypeId=" + tFirsttypeId +
            ", tSectypePic=" + tSectypePic +
            ", tSectypeDescription=" + tSectypeDescription +
            ", tSectypeIsvalid=" + tSectypeIsvalid +
        "}";
    }
}
