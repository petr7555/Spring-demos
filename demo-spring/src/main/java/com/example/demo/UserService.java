package com.example.demo;

import com.example.utils.NullAwareBeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Petr Janik 485122
 * @since 01/08/2019
 */
@Service
public class UserService {
    private final AtomicLong counter = new AtomicLong();

    private final Map<Long, UserDto> users = new HashMap<Long, UserDto>() {
        {
            put(counter.incrementAndGet(), new UserDto("oneName", "oneSurname", "one@one.cz", "onepass"));
            put(counter.incrementAndGet(), new UserDto("twoName", "twoSurname", "two@two.cz", "twopass"));
            put(counter.incrementAndGet(), new UserDto("threeName", "threeSurname", "three@three.cz", "threepass"));
        }
    };

    Map<Long, UserDto> all() {
        return users;
    }

    UserDto updateUser(UserDto userDto, Long userId) throws InvocationTargetException, IllegalAccessException {
        UserDto updatedUserDto = users.get(userId);
        BeanUtilsBean notNull = new NullAwareBeanUtilsBean();
        notNull.copyProperties(updatedUserDto, userDto);
        return updatedUserDto;
    }
}
