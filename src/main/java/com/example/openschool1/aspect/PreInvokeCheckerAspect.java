package com.example.openschool1.aspect;

import com.example.openschool1.annotation.PreInvoke;
import com.example.openschool1.exception.PlantException;
import com.example.openschool1.model.RoleType;
import com.example.openschool1.utils.UserContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Aspect
@Order(2)
public class PreInvokeCheckerAspect {

    private static final Map<String, List<RoleType>> USERS = new HashMap<>();

    static {
        USERS.put("admin", List.of(RoleType.ADMIN, RoleType.USER));
        USERS.put("user", List.of(RoleType.USER));
    }

    @Pointcut("@annotation(preInvoke)")
    public void checkRulePointcut(PreInvoke preInvoke) {
    }

    @Before(value = "checkRulePointcut(preInvoke)", argNames = "preInvoke")
    public void before(PreInvoke preInvoke) {
        String user = UserContext.getUsername();

        if (!USERS.containsKey(user)) {
            throw new PlantException("Пользователь не найден " + user);
        }
        var roles = Arrays.stream(preInvoke.roles()).toList();
        var userRoles = USERS.get(user);

        if (roles.stream().noneMatch(userRoles::contains)) {
            throw new PlantException("Доступ запрещён! Роли: " + userRoles);
        }
    }


}
