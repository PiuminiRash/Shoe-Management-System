//package lk.ijse.gdse66.springboot.backend.backend.api;
//
//import lk.ijse.gdse66.springboot.backend.backend.auth.Request.SignInRequest;
//import lk.ijse.gdse66.springboot.backend.backend.auth.Request.SignUpRequest;
//import lk.ijse.gdse66.springboot.backend.backend.auth.Response.JWTAuthResponse;
//import lk.ijse.gdse66.springboot.backend.backend.services.AuthenticationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping(" api/v1/auth")
//@RequiredArgsConstructor
//@CrossOrigin
//public class LoginController {
//
//    private final AuthenticationService authenticationService;
//
//    @PostMapping("/signin")
//    public ResponseEntity<JWTAuthResponse> signIn(
//            @RequestBody SignInRequest signInRequest){
//        System.out.println("Signing in");
//        return ResponseEntity.ok(
//                authenticationService.signIn(signInRequest));
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<JWTAuthResponse> signUp(
//            @RequestBody SignUpRequest signUpRequest){
//        return ResponseEntity.ok(
//                authenticationService.signUp(signUpRequest));
//    }
//}
