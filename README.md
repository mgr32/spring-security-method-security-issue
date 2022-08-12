This project shows the breaking change for handling `@RolesAllowed` annotation between the legacy method security implementation (`@EnableGlobalMethodSecurity`) and the new one (`@EnableMethodSecurity`).

It has two endpoints (`SecuredController`) protected with basic authentication (user `guest` pass `guest`):
* `GET /rolesAllowed_GUEST` - protected with `@RolesAllowed("GUEST")`,
* `GET /rolesAllowed_ROLE_GUEST` - protected with `@RolesAllowed("ROLE_GUEST")`.

There are two Spring profiles available:
* `legacyMethodSecurity` - using `@EnableGlobalMethodSecurity(jsr250Enabled = true)`,
* `newMethodSecurity` - using `@EnableMethodSecurity(jsr250Enabled = true)`.

And two test classes running basic auth request to both endpoints:
* `LegacyMethodSecurityTest` - activating profile `legacyMethodSecurity`, working OK for bot endpoints,
* `NewMethodSecurityTest` - activating profile `newMethodSecurity`, working OK for `/rolesAllowed_GUEST`, but not for `/rolesAllowed_ROLE_GUEST`.

To run the tests from command line (4 tests passing, 1 failing - ` NewMethodSecurityTest>AbstractMethodSecurityTest.rolesAllowed_ROLE_GUEST`):

`./mvnw test`


