package codereview.RPCService.impl;

import codereview.RPCService.RPCService;

/**
 * @author: guangxush
 * @create: 2019/03/25
 */
public class RPCServiceImpl implements RPCService {
    @Override
    public String showSomething(String args) {
        return args+", world!";
    }
}
