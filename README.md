This project shows the breaking change for handling `@RolesAllowed` annotation between the legacy method security implementation (`@EnableGlobalMethodSecurity`) and the new one (`@EnableMethodSecurity`).

It has two endpoints (`SecuredController`) protected with basic authentication (user `guest` pass `guest`):
* `GET /helloGuest` - protected with `@RolesAllowed("GUEST")`
* `GET /helloRoleGuest` - protected with `@RolesAllowed("ROLE_GUEST")`

There are two Spring profiles available:
* `legacyMethodSecurity` - using `@EnableGlobalMethodSecurity(jsr250Enabled = true)`
* `newMethodSecurity` - using `@EnableMethodSecurity(jsr250Enabled = true)`

And two test classes running basic auth request to both endpoints:
* `LegacyMethodSecurityTest` - activating profile `legacyMethodSecurity`, working OK for both endpoints
* `NewMethodSecurityTest` - activating profile `newMethodSecurity`, working OK for `/helloGuest`, but not for `/helloRoleGuest`

To run the tests from command line (3 tests passing, 1 failing - `NewMethodSecurityTest>AbstractMethodSecurityTest.endpointAllowingROLE_GUESTshouldAllowGuest`):

`./mvnw test`


