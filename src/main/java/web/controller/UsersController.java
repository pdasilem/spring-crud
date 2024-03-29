package web.controller;

import web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {

    private static final String REDIRECT_USERS_PATH = "redirect:/users";

    @Autowired
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String printUsers(Model model){
        model.addAttribute("userModels", userService.userList());
        return "users/users";
    }

    //создается пустой объект user
    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") UserModel userModel) {

        return "users/new";
    }
    //создается объект user и в него подтягиваются данные в соответствии с полями
    @PostMapping()
    public String createUser(@ModelAttribute("user") UserModel userModel) {
        userService.save(userModel);
        return REDIRECT_USERS_PATH;
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.show(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") UserModel userModel, @PathVariable("id") long id) {
        userService.update(id, userModel);
        return REDIRECT_USERS_PATH;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(id);
        return REDIRECT_USERS_PATH;
    }
}
