package chen.study.service;

import chen.study.domain.Account;

import java.util.List;

/**
 * 账户的业务层的接口
 */
public interface AccountService {
    /**
     * 模拟保存账户
     */
    public void saveAccount();
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);
}
