import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('families',function(){
    this.route('family_new',{path:'/new'});
    this.route('family',{path:'/:family_id'});
  });
});

export default Router;
