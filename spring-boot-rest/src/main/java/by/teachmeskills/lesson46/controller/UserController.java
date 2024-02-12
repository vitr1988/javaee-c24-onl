package by.teachmeskills.lesson46.controller;

import by.teachmeskills.lesson46.dto.CreateUserDto;
import by.teachmeskills.lesson46.dto.UserDto;
import by.teachmeskills.lesson46.entity.RoleEnum;
import by.teachmeskills.lesson46.jpa.OffsetLimitPageable;
import by.teachmeskills.lesson46.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "users", description = "There is some information about users of the system")
public class UserController {

    private final UserService userService;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    private final List<RoleEnum> roles;

    //    @ResponseBody
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(produces = "application/xml")
    @Operation(operationId = "all", description = "Fetch all users")
    public List<UserDto> getAll(
            @Parameter(required = false) @CookieValue(value = "test", required = false) String cookieValue,
            @RequestParam(required = false) String name
    ) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                log.info("cookie name {} with value {}", cookie.getName(), cookie.getValue());
            }
        }
        log.info("Test cookie {}", cookieValue);
        Cookie cookie = new Cookie("test", "123");
        response.addCookie(cookie);
        return StringUtils.isEmpty(name) ? userService.getAll() : userService.findByName(name);
    }

    @GetMapping("/http")
    public List<UserDto> findAll(@RequestParam(defaultValue = "10") Integer limit, @RequestParam(defaultValue = "0") Long offset) {
//        return userService.getAllByHttp();
        if (limit > 10) {
            limit = 10;
        }
        if (offset < 0) {
            offset = 0L;
        }
        return userService.getAll(OffsetLimitPageable.of(offset, limit, Sort.by(Sort.Direction.DESC, "id")));
    }

    @GetMapping(value = "/{userId}"//, produces = MediaType.APPLICATION_XML_VALUE
    )
    @ApiResponse(responseCode = "200", description = "get info about user if everything is ok")
    @ApiResponse(responseCode = "400", description = "validation failed")
    public ResponseEntity<UserDto> getById(@PathVariable("userId") Long id) {
        UserDto result = userService.getById(id);
        return ResponseEntity.ok(result);
    }

    @Hidden
    @GetMapping(value = "/{userId}/avatar", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getAvatarById(@PathVariable("userId") Long id) {
        UserDto result = userService.getById(id);
        return ResponseEntity.ok(result.getAvatar());
    }

    @SneakyThrows
    @PostMapping
    @PreAuthorize("@userRights.contains(T(by.teachmeskills.lesson46.entity.RoleEnum).ADMIN)")
    public ResponseEntity<UserDto> create(
//            @AuthenticationPrincipal User user,
            @RequestPart("avatar") MultipartFile avatarFile
            , @RequestPart("user") @Valid CreateUserDto userDto) {
        if (userDto.getId() != null) {
            return ResponseEntity.badRequest().build();
        }
        userDto.setAvatar(avatarFile.getBytes());
        log.info("file name {} {}", avatarFile.getName(), avatarFile.getBytes().length);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-UniqueHeader", UUID.randomUUID().toString());
        return new ResponseEntity<>(
                userService.create(userDto),
                httpHeaders,
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        if (!Objects.equals(id, userDto.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Optional<UserDto> result = userService.getAll().stream()
                .filter(it -> Objects.equals(id, it.getId()))
                .findFirst();
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        UserDto response = result.get();
        if (!StringUtils.isEmpty(userDto.getName())) {
            response.setName(userDto.getName());
        }
        if (!StringUtils.isEmpty(userDto.getLastName())) {
            response.setLastName(userDto.getLastName());
        }
        if (!StringUtils.isEmpty(userDto.getLogin())) {
            response.setLogin(userDto.getLogin());
        }
        userService.update(id, response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
