package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.container.page.PageHandler;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.entity.PageResult;
import com.pinyougou.mapper.TbSellerMapper;
import com.pinyougou.pojo.TbSeller;
import com.pinyougou.pojo.TbSellerExample;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * Created by
 * kim on 2019/5/26.
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    TbSellerMapper tbSellerMapper;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<TbSeller> findAll() {
        return tbSellerMapper.selectByExample(null);
    }

    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        Page<TbSeller> tbSellers = (Page<TbSeller>) tbSellerMapper.selectByExample(null);
        return new PageResult(tbSellers.getTotal(), tbSellers.getResult());
    }

    /**
     * 增加
     *
     * @param seller
     */
    @Override
    public void add(TbSeller seller) {
        seller.setStatus("0");
        seller.setCreateTime(new Date());
        tbSellerMapper.insert(seller);
    }

    /**
     * 修改
     *
     * @param seller
     */
    @Override
    public void update(TbSeller seller) {

        tbSellerMapper.updateByPrimaryKey(seller);

    }

    /**
     * 根据id获取实体
     *
     * @param id
     * @return
     */
    @Override
    public TbSeller findOne(String id) {

        return tbSellerMapper.selectByPrimaryKey(id);
    }

    /**
     * 删除
     *
     * @param ids
     */
    @Override
    public void delete(String[] ids) {

        for (String id : ids
                ) {

            tbSellerMapper.deleteByPrimaryKey(id);

        }

    }

    /**
     * 查询分页
     *
     * @param seller
     * @param pageNum  当前页 码
     * @param pageSize 每页记录数
     * @return
     */
    @Override
    public PageResult findPage(TbSeller seller, int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        TbSellerExample example = new TbSellerExample();
        TbSellerExample.Criteria criteria = example.createCriteria();

        if (seller != null) {
            if (seller.getSellerId() != null && seller.getSellerId().length() > 0) {
                criteria.andSellerIdLike("%" + seller.getSellerId() + "%");
            }
            if (seller.getName() != null && seller.getName().length() > 0) {
                criteria.andNameLike("%" + seller.getName() + "%");
            }
            if (seller.getNickName() != null && seller.getNickName().length() > 0) {
                criteria.andNickNameLike("%" + seller.getNickName() + "%");
            }
            if (seller.getPassword() != null && seller.getPassword().length() > 0) {
                criteria.andPasswordLike("%" + seller.getPassword() + "%");
            }
            if (seller.getEmail() != null && seller.getEmail().length() > 0) {
                criteria.andEmailLike("%" + seller.getEmail() + "%");
            }
            if (seller.getMobile() != null && seller.getMobile().length() > 0) {
                criteria.andMobileLike("%" + seller.getMobile() + "%");
            }
            if (seller.getTelephone() != null && seller.getTelephone().length() > 0) {
                criteria.andTelephoneLike("%" + seller.getTelephone() + "%");
            }
            if (seller.getStatus() != null && seller.getStatus().length() > 0) {
                criteria.andStatusLike("%" + seller.getStatus() + "%");
            }
            if (seller.getAddressDetail() != null && seller.getAddressDetail().length() > 0) {
                criteria.andAddressDetailLike("%" + seller.getAddressDetail() + "%");
            }
            if (seller.getLinkmanName() != null && seller.getLinkmanName().length() > 0) {
                criteria.andLinkmanNameLike("%" + seller.getLinkmanName() + "%");
            }
            if (seller.getLinkmanQq() != null && seller.getLinkmanQq().length() > 0) {
                criteria.andLinkmanQqLike("%" + seller.getLinkmanQq() + "%");
            }
            if (seller.getLinkmanMobile() != null && seller.getLinkmanMobile().length() > 0) {
                criteria.andLinkmanMobileLike("%" + seller.getLinkmanMobile() + "%");
            }
            if (seller.getLinkmanEmail() != null && seller.getLinkmanEmail().length() > 0) {
                criteria.andLinkmanEmailLike("%" + seller.getLinkmanEmail() + "%");
            }
            if (seller.getLicenseNumber() != null && seller.getLicenseNumber().length() > 0) {
                criteria.andLicenseNumberLike("%" + seller.getLicenseNumber() + "%");
            }
            if (seller.getTaxNumber() != null && seller.getTaxNumber().length() > 0) {
                criteria.andTaxNumberLike("%" + seller.getTaxNumber() + "%");
            }
            if (seller.getOrgNumber() != null && seller.getOrgNumber().length() > 0) {
                criteria.andOrgNumberLike("%" + seller.getOrgNumber() + "%");
            }
            if (seller.getLogoPic() != null && seller.getLogoPic().length() > 0) {
                criteria.andLogoPicLike("%" + seller.getLogoPic() + "%");
            }
            if (seller.getBrief() != null && seller.getBrief().length() > 0) {
                criteria.andBriefLike("%" + seller.getBrief() + "%");
            }
            if (seller.getLegalPerson() != null && seller.getLegalPerson().length() > 0) {
                criteria.andLegalPersonLike("%" + seller.getLegalPerson() + "%");
            }
            if (seller.getLegalPersonCardId() != null && seller.getLegalPersonCardId().length() > 0) {
                criteria.andLegalPersonCardIdLike("%" + seller.getLegalPersonCardId() + "%");
            }
            if (seller.getBankUser() != null && seller.getBankUser().length() > 0) {
                criteria.andBankUserLike("%" + seller.getBankUser() + "%");
            }
            if (seller.getBankName() != null && seller.getBankName().length() > 0) {
                criteria.andBankNameLike("%" + seller.getBankName() + "%");
            }
        }
        Page<TbSeller> page = (Page<TbSeller>) tbSellerMapper.selectByExample(example);
        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    public void updateStatus(String sellerId, String status) {

        TbSeller tbSeller = tbSellerMapper.selectByPrimaryKey(sellerId);
        tbSeller.setStatus(status);
        tbSellerMapper.updateByPrimaryKey(tbSeller);

    }
}
